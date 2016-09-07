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
         * srpId : b38555519d4f840d48b0a63691ccdebb
         * imageUrl : http://souyue-xqq.b0.upaiyun.com/newssource/1609/w28tmint5xm214730390118226-20160905093011_200_200.jpg
         * countSubscribe : 20577
         * title :
         * desc :
         * keyword : g20峰会
         */

        private List<HotSubscribeListBean> hotSubscribeList;
        /**
         * invokeType : 10
         * docId :
         * docType : 1
         * srpId : 4cc914a8f16f30d66a289ce65d6e0782
         * imageUrl : http://souyue-xqq.b0.upaiyun.com/newssource/1609/athk7z9csgct14731410151714-20160906135015_460_300.jpg
         * countSubscribe : 17708
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
         * countSubscribe : 13889
         * title :
         * desc :
         * keyword : 黄海波
         * viewType : 95
         */

        private List<NewFoundListBean> newFoundList;
        /**
         * invokeType : 10
         * docId : http://z.zhongsou.net/news/080808_7139725.html
         * docType : 1
         * srpId : 5e5affb7d8efb37d78b6796600af4e4e
         * imageUrl : http://souyue-xqq.b0.upaiyun.com/newssource/1609/ggg91jzwb5cg14731406861877-20160906134446_640_330.jpg
         * countSubscribe : 19005
         * title : 一场浪迹天涯的学艺之旅……
         * desc :
         * keyword : 搞笑
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
            private String keyword;
            private int viewType;

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

            public int getViewType() {
                return viewType;
            }

            public void setViewType(int viewType) {
                this.viewType = viewType;
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
