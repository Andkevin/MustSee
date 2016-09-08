package com.android1604.mustsee.bean;

import java.util.List;

/**
 * Created by my on 2016/9/6.
 */
public class ExploreInfoBean {

    /**
     * status : 200
     * hasMore : false
     */

    private HeadBean head;
    private BodyBean body;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class HeadBean {
        private int status;
        private boolean hasMore;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isHasMore() {
            return hasMore;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }
    }

    public static class BodyBean {
        /**
         * invokeType : 10
         * docId :
         * docType : 1
         * srpId : 6632a61e53929f8dd5931c36a7016c74
         * imageUrl : http://souyue-xqq.b0.upaiyun.com/newssource/1609/1r1e2fop68wv14731403910941-20160906133951_200_200.jpg
         * countSubscribe : 13889
         * title :
         * desc :
         * keyword : 郭德纲
         */

        private List<HotSubscribeListBean> hotSubscribeList;
        /**
         * invokeType : 10
         * docId :
         * docType : 1
         * srpId : 4cc914a8f16f30d66a289ce65d6e0782
         * imageUrl : http://souyue-xqq.b0.upaiyun.com/newssource/1609/athk7z9csgct14731410151714-20160906135015_460_300.jpg
         * countSubscribe : 10914
         * title : 分享历史老照片 探索神秘事物！
         * desc :
         * keyword : 大嘴侃历史
         */

        private List<RecommentListBean> recommentList;
        /**
         * invokeType : 95
         * docId :
         * docType : 1
         * srpId : c34c2cde7e067f0bf45c191049ad40de
         * imageUrl : http://edit.zhongsou.com/Img/getSrpImg?srpId=c34c2cde7e067f0bf45c191049ad40de
         * countSubscribe : 22145
         * title : 黄海波复出拍戏搭档小宋佳和张馨予现场道具复杂
         * desc :
         * source : 中国青年网
         * image : ["http://souyue-image.b0.upaiyun.com/newspic/list/8c/c4/4208cc4055a82042708_android.jpg!android"]
         * keyword : 黄海波
         * viewType : 95
         */

        private List<NewFoundListBean> newFoundList;
        /**
         * invokeType : 10
         * docId : http://www.yidianzixun.com/home?page=article&id=0ENHMNVE&up=1
         * docType : 1
         * srpId : eef7b484b0693ea845018b8eb4857fe9
         * imageUrl : http://souyue-xqq.b0.upaiyun.com/newssource/1609/ce0sjgmkvsfc14732127168018-20160907094516_640_330.jpg
         * countSubscribe : 18441
         * title : 今日白露，咱们应该了解这些知识
         * desc :
         * keyword : 白露
         */

        private List<RollingImagesListBean> rollingImagesList;

        public List<HotSubscribeListBean> getHotSubscribeList() {
            return hotSubscribeList;
        }

        public void setHotSubscribeList(List<HotSubscribeListBean> hotSubscribeList) {
            this.hotSubscribeList = hotSubscribeList;
        }

        public List<RecommentListBean> getRecommentList() {
            return recommentList;
        }

        public void setRecommentList(List<RecommentListBean> recommentList) {
            this.recommentList = recommentList;
        }

        public List<NewFoundListBean> getNewFoundList() {
            return newFoundList;
        }

        public void setNewFoundList(List<NewFoundListBean> newFoundList) {
            this.newFoundList = newFoundList;
        }

        public List<RollingImagesListBean> getRollingImagesList() {
            return rollingImagesList;
        }

        public void setRollingImagesList(List<RollingImagesListBean> rollingImagesList) {
            this.rollingImagesList = rollingImagesList;
        }

        public static class HotSubscribeListBean {
            private int invokeType;
            private String docId;
            private int docType;
            private String srpId;
            private String imageUrl;
            private int countSubscribe;
            private String title;
            private String desc;
            private String keyword;

            public int getInvokeType() {
                return invokeType;
            }

            public void setInvokeType(int invokeType) {
                this.invokeType = invokeType;
            }

            public String getDocId() {
                return docId;
            }

            public void setDocId(String docId) {
                this.docId = docId;
            }

            public int getDocType() {
                return docType;
            }

            public void setDocType(int docType) {
                this.docType = docType;
            }

            public String getSrpId() {
                return srpId;
            }

            public void setSrpId(String srpId) {
                this.srpId = srpId;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getCountSubscribe() {
                return countSubscribe;
            }

            public void setCountSubscribe(int countSubscribe) {
                this.countSubscribe = countSubscribe;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }
        }

        public static class RecommentListBean {
            private int invokeType;
            private String docId;
            private int docType;
            private String srpId;
            private String imageUrl;
            private int countSubscribe;
            private String title;
            private String desc;
            private String keyword;

            public int getInvokeType() {
                return invokeType;
            }

            public void setInvokeType(int invokeType) {
                this.invokeType = invokeType;
            }

            public String getDocId() {
                return docId;
            }

            public void setDocId(String docId) {
                this.docId = docId;
            }

            public int getDocType() {
                return docType;
            }

            public void setDocType(int docType) {
                this.docType = docType;
            }

            public String getSrpId() {
                return srpId;
            }

            public void setSrpId(String srpId) {
                this.srpId = srpId;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getCountSubscribe() {
                return countSubscribe;
            }

            public void setCountSubscribe(int countSubscribe) {
                this.countSubscribe = countSubscribe;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }
        }

        public static class NewFoundListBean {
            private int invokeType;
            private String docId;
            private int docType;
            private String srpId;
            private String imageUrl;
            private int countSubscribe;
            private String title;
            private String desc;
            private String source;
            private String keyword;
            private int viewType;
            private List<String> image;

            public int getInvokeType() {
                return invokeType;
            }

            public void setInvokeType(int invokeType) {
                this.invokeType = invokeType;
            }

            public String getDocId() {
                return docId;
            }

            public void setDocId(String docId) {
                this.docId = docId;
            }

            public int getDocType() {
                return docType;
            }

            public void setDocType(int docType) {
                this.docType = docType;
            }

            public String getSrpId() {
                return srpId;
            }

            public void setSrpId(String srpId) {
                this.srpId = srpId;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getCountSubscribe() {
                return countSubscribe;
            }

            public void setCountSubscribe(int countSubscribe) {
                this.countSubscribe = countSubscribe;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public int getViewType() {
                return viewType;
            }

            public void setViewType(int viewType) {
                this.viewType = viewType;
            }

            public List<String> getImage() {
                return image;
            }

            public void setImage(List<String> image) {
                this.image = image;
            }
        }

        public static class RollingImagesListBean {
            private int invokeType;
            private String docId;
            private int docType;
            private String srpId;
            private String imageUrl;
            private int countSubscribe;
            private String title;
            private String desc;
            private String keyword;

            public int getInvokeType() {
                return invokeType;
            }

            public void setInvokeType(int invokeType) {
                this.invokeType = invokeType;
            }

            public String getDocId() {
                return docId;
            }

            public void setDocId(String docId) {
                this.docId = docId;
            }

            public int getDocType() {
                return docType;
            }

            public void setDocType(int docType) {
                this.docType = docType;
            }

            public String getSrpId() {
                return srpId;
            }

            public void setSrpId(String srpId) {
                this.srpId = srpId;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getCountSubscribe() {
                return countSubscribe;
            }

            public void setCountSubscribe(int countSubscribe) {
                this.countSubscribe = countSubscribe;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }
        }
    }
}
