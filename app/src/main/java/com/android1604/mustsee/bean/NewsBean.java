package com.android1604.mustsee.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 *
 */
public class NewsBean {

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
        private List<?> topList;
        /**
         * invokeType : 80
         * viewType : 80
         * id : 7137263
         * title : 电影中套路满满的表白方式
         * imgRatio : 149
         * bigImgUrl : http://souyue-xqq.b0.upaiyun.com/video/1609/gav9u6x7sfng14730706211277-20160905181701_500_335.jpg
         * phoneImageUrl : http://200006652.vod.myqcloud.com/200006652_37aa4718b3d48e6aabd9d1b846bd667b8d9ef636.f10.mp4
         * image : ["http://souyue-xqq.b0.upaiyun.com/video/1609/gav9u6x7sfng14730706211277-20160905181701_500_335.jpg"]
         * srpId : 42
         * keyword :
         * imgCount : 0
         * isInvokeTemplate : 1
         * docId : http://sycms.zhongsou.com/Api/VideoNews?keyid=7137263
         * docType : 5
         * duration : 04:17
         * footView : {"footType":4,"source":"优酷","channelName":"","ctime":1473004800000,"showShare":1,"showFavorator":1,"shareUrl":"http://tt.zhongsou.com/u/LuNy","isDown":0,"downCount":-1,"upCount":2,"commentCount":0,"isUp":0,"isFavorator":0}
         */

        private List<NewsListBean> newsList;
        private List<?> allViewList;
        private List<?> hotSearchList;

        public List<?> getTopList() {
            return topList;
        }

        public void setTopList(List<?> topList) {
            this.topList = topList;
        }

        public List<NewsListBean> getNewsList() {
            return newsList;
        }

        public void setNewsList(List<NewsListBean> newsList) {
            this.newsList = newsList;
        }

        public List<?> getAllViewList() {
            return allViewList;
        }

        public void setAllViewList(List<?> allViewList) {
            this.allViewList = allViewList;
        }

        public List<?> getHotSearchList() {
            return hotSearchList;
        }

        public void setHotSearchList(List<?> hotSearchList) {
            this.hotSearchList = hotSearchList;
        }

        public static class NewsListBean {
            private String invokeType;
            private String viewType;
            private String id;
            private String title;
            private String imgRatio;
            private String bigImgUrl;
            private String phoneImageUrl;
            private String srpId;
            private String keyword;
            private String imgCount;
            private String isInvokeTemplate;
            private String docId;
            private String docType;
            private String duration;
            /**
             * footType : 4
             * source : 优酷
             * channelName :
             * ctime : 1473004800000
             * showShare : 1
             * showFavorator : 1
             * shareUrl : http://tt.zhongsou.com/u/LuNy
             * isDown : 0
             * downCount : -1
             * upCount : 2
             * commentCount : 0
             * isUp : 0
             * isFavorator : 0
             */

            private FootViewBean footView;
            private List<String> image;

            public String getInvokeType() {
                return invokeType;
            }

            public void setInvokeType(String invokeType) {
                this.invokeType = invokeType;
            }

            public String getViewType() {
                return viewType;
            }

            public void setViewType(String viewType) {
                this.viewType = viewType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgRatio() {
                return imgRatio;
            }

            public void setImgRatio(String imgRatio) {
                this.imgRatio = imgRatio;
            }

            public String getBigImgUrl() {
                return bigImgUrl;
            }

            public void setBigImgUrl(String bigImgUrl) {
                this.bigImgUrl = bigImgUrl;
            }

            public String getPhoneImageUrl() {
                return phoneImageUrl;
            }

            public void setPhoneImageUrl(String phoneImageUrl) {
                this.phoneImageUrl = phoneImageUrl;
            }

            public String getSrpId() {
                return srpId;
            }

            public void setSrpId(String srpId) {
                this.srpId = srpId;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getImgCount() {
                return imgCount;
            }

            public void setImgCount(String imgCount) {
                this.imgCount = imgCount;
            }

            public String getIsInvokeTemplate() {
                return isInvokeTemplate;
            }

            public void setIsInvokeTemplate(String isInvokeTemplate) {
                this.isInvokeTemplate = isInvokeTemplate;
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

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public FootViewBean getFootView() {
                return footView;
            }

            public void setFootView(FootViewBean footView) {
                this.footView = footView;
            }

            public List<String> getImage() {
                return image;
            }

            public void setImage(List<String> image) {
                this.image = image;
            }

            public static class FootViewBean {
                private String footType;
                private String source;
                private String channelName;
                private long ctime;
                private String showShare;
                private String showFavorator;
                private String shareUrl;
                private String isDown;
                private String downCount;
                private String upCount;
                private String commentCount;
                private String isUp;
                private String isFavorator;

                public String getFootType() {
                    return footType;
                }

                public void setFootType(String footType) {
                    this.footType = footType;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getChannelName() {
                    return channelName;
                }

                public void setChannelName(String channelName) {
                    this.channelName = channelName;
                }

                public long getCtime() {
                    return ctime;
                }

                public void setCtime(long ctime) {
                    this.ctime = ctime;
                }

                public String getShowShare() {
                    return showShare;
                }

                public void setShowShare(String showShare) {
                    this.showShare = showShare;
                }

                public String getShowFavorator() {
                    return showFavorator;
                }

                public void setShowFavorator(String showFavorator) {
                    this.showFavorator = showFavorator;
                }

                public String getShareUrl() {
                    return shareUrl;
                }

                public void setShareUrl(String shareUrl) {
                    this.shareUrl = shareUrl;
                }

                public String getIsDown() {
                    return isDown;
                }

                public void setIsDown(String isDown) {
                    this.isDown = isDown;
                }

                public String getDownCount() {
                    return downCount;
                }

                public void setDownCount(String downCount) {
                    this.downCount = downCount;
                }

                public String getUpCount() {
                    return upCount;
                }

                public void setUpCount(String upCount) {
                    this.upCount = upCount;
                }

                public String getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(String commentCount) {
                    this.commentCount = commentCount;
                }

                public String getIsUp() {
                    return isUp;
                }

                public void setIsUp(String isUp) {
                    this.isUp = isUp;
                }

                public String getIsFavorator() {
                    return isFavorator;
                }

                public void setIsFavorator(String isFavorator) {
                    this.isFavorator = isFavorator;
                }
            }
        }
    }
}
