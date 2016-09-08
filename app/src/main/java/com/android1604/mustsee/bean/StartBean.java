package com.android1604.mustsee.bean;

/**
 * Created by Administrator on 2016/9/7.
 */
public class StartBean {

    /**
     * status : 200
     * hasMore : false
     */

    private HeadBean head;
    /**
     * cleanNewsList : 0
     * cleanBrowserCache : 0
     * splashScreen : {"url":"http://sns-img.b0.upaiyun.com/selfcreate/1609/0518/28/4sm4ff7lhwky14730713028155-20160905182822.jpg","expiredStartTime":"2016-09-07 00:00:11","expiredEndTime":"2016-09-07 23:55:11","offsetTime":583624,"exhibitionTime":3000,"isjump":0,"invokeType":10,"invokeUrl":""}
     */

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
        private int cleanNewsList;
        private int cleanBrowserCache;
        /**
         * url : http://sns-img.b0.upaiyun.com/selfcreate/1609/0518/28/4sm4ff7lhwky14730713028155-20160905182822.jpg
         * expiredStartTime : 2016-09-07 00:00:11
         * expiredEndTime : 2016-09-07 23:55:11
         * offsetTime : 583624
         * exhibitionTime : 3000
         * isjump : 0
         * invokeType : 10
         * invokeUrl :
         */

        private SplashScreenBean splashScreen;

        public int getCleanNewsList() {
            return cleanNewsList;
        }

        public void setCleanNewsList(int cleanNewsList) {
            this.cleanNewsList = cleanNewsList;
        }

        public int getCleanBrowserCache() {
            return cleanBrowserCache;
        }

        public void setCleanBrowserCache(int cleanBrowserCache) {
            this.cleanBrowserCache = cleanBrowserCache;
        }

        public SplashScreenBean getSplashScreen() {
            return splashScreen;
        }

        public void setSplashScreen(SplashScreenBean splashScreen) {
            this.splashScreen = splashScreen;
        }

        public static class SplashScreenBean {
            private String url;
            private String expiredStartTime;
            private String expiredEndTime;
            private int offsetTime;
            private int exhibitionTime;
            private int isjump;
            private int invokeType;
            private String invokeUrl;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getExpiredStartTime() {
                return expiredStartTime;
            }

            public void setExpiredStartTime(String expiredStartTime) {
                this.expiredStartTime = expiredStartTime;
            }

            public String getExpiredEndTime() {
                return expiredEndTime;
            }

            public void setExpiredEndTime(String expiredEndTime) {
                this.expiredEndTime = expiredEndTime;
            }

            public int getOffsetTime() {
                return offsetTime;
            }

            public void setOffsetTime(int offsetTime) {
                this.offsetTime = offsetTime;
            }

            public int getExhibitionTime() {
                return exhibitionTime;
            }

            public void setExhibitionTime(int exhibitionTime) {
                this.exhibitionTime = exhibitionTime;
            }

            public int getIsjump() {
                return isjump;
            }

            public void setIsjump(int isjump) {
                this.isjump = isjump;
            }

            public int getInvokeType() {
                return invokeType;
            }

            public void setInvokeType(int invokeType) {
                this.invokeType = invokeType;
            }

            public String getInvokeUrl() {
                return invokeUrl;
            }

            public void setInvokeUrl(String invokeUrl) {
                this.invokeUrl = invokeUrl;
            }
        }
    }
}
