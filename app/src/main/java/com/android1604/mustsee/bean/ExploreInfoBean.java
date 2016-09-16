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
         * countSubscribe : 12584
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
         * countSubscribe : 12701
         * title : 分享历史老照片 探索神秘事物！
         * desc :
         * keyword : 大嘴侃历史
         */

        private List<RecommentListBean> recommentList;
        /**
         * invokeType : 95
         * docId :
         * docType : 1
         * footView : {"commentCount":-1,"ctime":0,"downCount":-1,"footType":1,"isDown":0,"source":"中国青年网 ","upCount":-1}
         * srpId : c34c2cde7e067f0bf45c191049ad40de
         * imageUrl : http://edit.zhongsou.com/Img/getSrpImg?srpId=c34c2cde7e067f0bf45c191049ad40de
         * countSubscribe : 15405
         * id : 100021472522820000
         * image : ["http://souyue-image.b0.upaiyun.com/newspic/list/8c/c4/4208cc4055a82042708_android.jpg!android"]
         * title :
         * desc :
         * keyword : 黄海波
         * viewType : 95
         */

        private List<NewFoundListBean> newFoundList;
        /**
         * invokeType : 10
         * docId : http://dajia.qq.com/original/category/njs160907.html
         * docType : 1
         * srpId : 6632a61e53929f8dd5931c36a7016c74
         * imageUrl : http://souyue-xqq.b0.upaiyun.com/newssource/1609/ewx9lzv92lnz14733060744104-20160908114114_640_330.jpg
         * countSubscribe : 21366
         * title : 传统相声界的师父，真不是郭德纲那样的
         * desc :
         * keyword : 郭德纲
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
            /**
             * commentCount : -1
             * ctime : 0
             * downCount : -1
             * footType : 1
             * isDown : 0
             * source : 中国青年网
             * upCount : -1
             */

            private FootViewBean footView;
            private String srpId;
            private String imageUrl;
            private int countSubscribe;
            private long id;
            private String title;
            private String desc;
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

            public FootViewBean getFootView() {
                return footView;
            }

            public void setFootView(FootViewBean footView) {
                this.footView = footView;
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

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
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

            public List<String> getImage() {
                return image;
            }

            public void setImage(List<String> image) {
                this.image = image;
            }

            public static class FootViewBean {
                private int commentCount;
                private long ctime;
                private int downCount;
                private int footType;
                private int isDown;
                private String source;
                private int upCount;

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public long getCtime() {
                    return ctime;
                }

                public void setCtime(long ctime) {
                    this.ctime = ctime;
                }

                public int getDownCount() {
                    return downCount;
                }

                public void setDownCount(int downCount) {
                    this.downCount = downCount;
                }

                public int getFootType() {
                    return footType;
                }

                public void setFootType(int footType) {
                    this.footType = footType;
                }

                public int getIsDown() {
                    return isDown;
                }

                public void setIsDown(int isDown) {
                    this.isDown = isDown;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public int getUpCount() {
                    return upCount;
                }

                public void setUpCount(int upCount) {
                    this.upCount = upCount;
                }
            }
        }

        public static class RollingImagesListBean {
            private int invokeType;
            private String docId;
            private String docType;
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

            public String getDocType() {
                return docType;
            }

            public void setDocType(String docType) {
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
