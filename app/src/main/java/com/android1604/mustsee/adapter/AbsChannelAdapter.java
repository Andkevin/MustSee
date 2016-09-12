package com.android1604.mustsee.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.presenter.impl.InformationPresenterImpl;
import com.android1604.mustsee.ui.DragDropGirdView;
import com.android1604.mustsee.ui.OnDragDropListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 *
 */
public abstract class AbsChannelAdapter extends BaseAdapter implements OnDragDropListener {

    protected DragDropListener mDragDropListener;

    protected Context mContext;

    /**
     * Contact data stored in cache. This is used to populate the associated view.
     */
    protected ArrayList<TabTitlesBean.BodyBean.DataListBean> channels = null;
    /**
     * Back up of（备份） the temporarily removed Contact during dragging.
     */
    private TabTitlesBean.BodyBean.DataListBean tempChannel = null;
    /**
     * Position of the temporarily removed contact in the cache.
     */
    private int tempChannelIndex = -1;
    /**
     * New position of the temporarily removed contact in the cache.
     */
    private int newChannelIndex = -1;
    /**
     * New position of the temporarily entered contact in the cache.
     */
    private int mEnteredChannelIndex = -1;

    private boolean mAwaitingRemove = false;
    private boolean mDelayCursorUpdates = false;

    private int mAnimationDuration;

    /**
     * Indicates whether a drag is in process.
     */
    private boolean mInDragging = false;

    private int mTilesStartLimit = -1;

    private int mTilesEndLimit = Integer.MAX_VALUE;

    private final HashMap<Long, Integer> mItemIdTopMap = new HashMap<Long, Integer>();
    private final HashMap<Long, Integer> mItemIdLeftMap = new HashMap<Long, Integer>();


    public static TabTitlesBean.BodyBean.DataListBean BLANK_ENTRY = new TabTitlesBean.BodyBean.DataListBean();

    public interface DragDropListener {

        DragDropGirdView getDragDropGirdView();

        void onDataSetChangedForResult(ArrayList<TabTitlesBean.BodyBean.DataListBean> channels);
    }


    public AbsChannelAdapter(Context context,
                         DragDropListener dragDropListener) {
        mDragDropListener = dragDropListener;
        mContext = context;
        channels = new ArrayList<>();
        mAnimationDuration = context.getResources().getInteger(R.integer.fade_duration);
    }

    /**
     * thumbtack some view,start
     * @param startLimit
     */
    protected void setTilesStartLimit(int startLimit){
        mTilesStartLimit = startLimit;
    }

    public int getTilesStartLimit() {
        return mTilesStartLimit;
    }

    /**
     * thumbtack some view,end
     * @param endLimit
     */
    protected void setTilesEndLimit(int endLimit){
        mTilesEndLimit = endLimit;
    }


    public int getTilesEndLimit() {
        return mTilesEndLimit;
    }
    /**
     * Indicates whether a drag is in process.
     *
     * @param inDragging Boolean variable indicating whether there is a drag in process.
     */
    public void setInDragging(boolean inDragging) {
        mDelayCursorUpdates = inDragging;
        mInDragging = inDragging;
    }

    //当数据改变时调用
    public void setData(List<TabTitlesBean.BodyBean.DataListBean> channels) {
        if (!mDelayCursorUpdates && channels != null) {
            this.channels.clear();
            this.channels.addAll(channels);
            // cause a refreshData of any views that rely on this data
            notifyDataSetChanged();
            // about to start redraw
            onDataSetChangedForAnimation();
        }
    }


    @Override
    public int getCount() {
        return channels == null ? 0 : channels.size();
    }
   
    @Override
    public TabTitlesBean.BodyBean.DataListBean getItem(int position) {
        return channels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return getCount() > 0;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);

    @Override
    public int getViewTypeCount() {
        return ViewTypes.COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return ViewTypes.TILE;
    }

    /**
     * Temporarily(暂时的) removes a contact(接触) from the list for UI refreshData. Stores data for this contact
     * in the back-up variable.
     *
     * @param index Position of the contact to be removed.
     */
    public void popDragEntry(int index) {
        if (isIndexInBound(index)) {
            //备份一份被拖动的数据
            tempChannel = channels.get(index);
            tempChannelIndex = index;
            mEnteredChannelIndex = index;
            markDropArea(index);
        }
    }

    public boolean isIndexInBound(int itemIndex) {
        return itemIndex >= 0 && itemIndex < channels.size();
    }

 
    private void markDropArea(int itemIndex) {
        if (tempChannel != null && isIndexInBound(mEnteredChannelIndex) &&
                isIndexInBound(itemIndex)) {
            cacheOffsetsForDataSetChange();
            // Remove the old placeholder item and place the new placeholder item.
            final int oldIndex = mEnteredChannelIndex;
            channels.remove(mEnteredChannelIndex);
            mEnteredChannelIndex = itemIndex;
            channels.add(mEnteredChannelIndex, BLANK_ENTRY);
//            BLANK_ENTRY.setId(tempChannel.getId());
            //启动动画
            onDataSetChangedForAnimation();
            notifyDataSetChanged();
        }
    }

    /**
     * Drops the temporarily removed contact to the desired location in the list.
     */
    public void handleDrop() {
        if (tempChannel != null) {
            if (isIndexInBound(mEnteredChannelIndex) &&
                    mEnteredChannelIndex != tempChannelIndex) {
                newChannelIndex = mEnteredChannelIndex;
                channels.set(newChannelIndex, tempChannel);
                cacheOffsetsForDataSetChange();
                notifyDataSetChanged();
            } else if (isIndexInBound(tempChannelIndex)) {
                channels.remove(mEnteredChannelIndex);
                channels.add(tempChannelIndex, tempChannel);
                newChannelIndex = tempChannelIndex;
                notifyDataSetChanged();
            }
            tempChannel = null;

            if (tempChannelIndex != mEnteredChannelIndex) {
                mDragDropListener.onDataSetChangedForResult(channels);
            }

        }
    }


    protected static class ViewTypes {
        public static final int TILE = 0;
        public static final int COUNT = 1;
    }

    /**
     * @param view
     * @return
     */
    protected abstract TabTitlesBean.BodyBean.DataListBean getDragEntity(View view);

    @Override
    public void onDragStarted(int x, int y, View view) {
        setInDragging(true);
        final int itemIndex = channels.indexOf(getDragEntity(view));
        popDragEntry(itemIndex);
    }

    @Override
    public void onDragHovered(int x, int y, View view) {
        if (view == null) {
            return;
        }
        final int itemIndex = channels.indexOf(getDragEntity(view));
        if (mInDragging && mEnteredChannelIndex != itemIndex
                && isIndexInBound(itemIndex) && itemIndex > mTilesStartLimit &&  itemIndex < mTilesEndLimit) {
            markDropArea(itemIndex);
        }
    }

    @Override
    public void onDragFinished(int x, int y) {
        setInDragging(false);
        if (!mAwaitingRemove) {
            handleDrop();
        }
    }

    @Override
    public void onDroppedOnRemove() {
        if (tempChannel != null) {
            mAwaitingRemove = true;
        }
    }

    public void onDataSetChangedForAnimation(long... idsInPlace) {
        animateGridView(idsInPlace);
    }

    public void cacheOffsetsForDataSetChange() {
        saveOffsets();
    }


    /**
     * Performs animations for the gridView
     */
    private void animateGridView(final long... idsInPlace) {

        if (mItemIdTopMap.isEmpty()) {
            return;
        }

        final ViewTreeObserver observer = mDragDropListener.getDragDropGirdView().getViewTreeObserver();
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @SuppressWarnings("unchecked")
            @Override
            public boolean onPreDraw() {
                observer.removeOnPreDrawListener(this);
                final int firstVisiblePosition = mDragDropListener.getDragDropGirdView().getFirstVisiblePosition();

                final AnimatorSet animSet = new AnimatorSet();
                final ArrayList<Animator> animators = new ArrayList<Animator>();
                for (int i = 0; i < mDragDropListener.getDragDropGirdView().getChildCount(); i++) {
                    final View child = mDragDropListener.getDragDropGirdView().getChildAt(i);
                    int position = firstVisiblePosition + i;

                    if (!isIndexInBound(position)) {
                        continue;
                    }

                    final long itemId = getItemId(position);

                    if (containsId(idsInPlace, itemId)) {
                        animators.add(ObjectAnimator.ofFloat(
                                child, "alpha", 0.0f, 1.0f));
                        break;
                    } else {
                        Integer startTop = mItemIdTopMap.get(itemId);
                        Integer startLeft = mItemIdLeftMap.get(itemId);
                        final int top = child.getTop();
                        final int left = child.getLeft();
                        int deltaX = 0;
                        int deltaY = 0;

                        if (startLeft != null) {
                            if (startLeft != left) {
                                deltaX = startLeft - left;
                                animators.add(ObjectAnimator.ofFloat(
                                        child, "translationX", deltaX, 0.0f));
                            }
                        }

                        if (startTop != null) {
                            if (startTop != top) {
                                deltaY = startTop - top;
                                animators.add(ObjectAnimator.ofFloat(
                                        child, "translationY", deltaY, 0.0f));
                            }
                        }

                    }
                }

                if (animators.size() > 0) {
                    animSet.setDuration(mAnimationDuration).playTogether(animators);
                    animSet.start();
                }

                mItemIdTopMap.clear();
                mItemIdLeftMap.clear();
                return true;
            }
        });
    }

    private boolean containsId(long[] ids, long target) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == target) {
                return true;
            }
        }
        return false;
    }


    private void saveOffsets() {
        final int firstVisiblePosition = mDragDropListener.getDragDropGirdView().getFirstVisiblePosition();
        for (int i = 0; i < mDragDropListener.getDragDropGirdView().getChildCount(); i++) {
            final View child = mDragDropListener.getDragDropGirdView().getChildAt(i);
            final int position = firstVisiblePosition + i;

            if (!isIndexInBound(position)) {
                continue;
            }
            final long itemId = getItemId(position);

            /*Log.e("heheda", "Saving itemId: " + itemId + " for listview child " + i + " Top: "
                    + child.getTop() + " Left: "
                    + child.getLeft());*/

            mItemIdTopMap.put(itemId, child.getTop());
            mItemIdLeftMap.put(itemId, child.getLeft());
        }
    }
}
