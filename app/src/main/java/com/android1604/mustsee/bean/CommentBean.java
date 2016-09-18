package com.android1604.mustsee.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14.
 */
public class CommentBean {

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
         * sign_id : bc122b03d8828da997c6f1e93986c6e4
         * comment_id : 115670830
         * content : sdfdfds
         * voice :
         * voicelength : 0
         * images : []
         * create_time : 1473837162473
         * update_time : 1473837162473
         * good_num : 0
         * has_praised : false
         * image_url :
         * is_host : 1
         * nickname : 游客
         * user_id : 1007621438
         * srp_id : 106
         * srp_word : 生活+
         * type : 2
         * is_current_comment : 0
         * ishot : 0
         * appname : com.zhongsou.souyue.headline
         * identity : 2
         * replyList : []
         * replyListSize : 0
         * replyTotalSize : 0
         */

        private List<ListBean> list;
        private List<?> hotlist;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<?> getHotlist() {
            return hotlist;
        }

        public void setHotlist(List<?> hotlist) {
            this.hotlist = hotlist;
        }

        public static class ListBean {
            private String sign_id;
            private String comment_id;
            private String content;
            private String voice;
            private String voicelength;
            private long create_time;
            private long update_time;
            private String good_num;
            private boolean has_praised;
            private String image_url;
            private String is_host;
            private String nickname;
            private String user_id;
            private String srp_id;
            private String srp_word;
            private String type;
            private String is_current_comment;
            private String ishot;
            private String appname;
            private String identity;
            private String replyListSize;
            private String replyTotalSize;
            private List<?> images;
            private List<?> replyList;

            public String getSign_id() {
                return sign_id;
            }

            public void setSign_id(String sign_id) {
                this.sign_id = sign_id;
            }

            public String getComment_id() {
                return comment_id;
            }

            public void setComment_id(String comment_id) {
                this.comment_id = comment_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getVoice() {
                return voice;
            }

            public void setVoice(String voice) {
                this.voice = voice;
            }

            public String getVoicelength() {
                return voicelength;
            }

            public void setVoicelength(String voicelength) {
                this.voicelength = voicelength;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public long getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(long update_time) {
                this.update_time = update_time;
            }

            public String getGood_num() {
                return good_num;
            }

            public void setGood_num(String good_num) {
                this.good_num = good_num;
            }

            public boolean isHas_praised() {
                return has_praised;
            }

            public void setHas_praised(boolean has_praised) {
                this.has_praised = has_praised;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getIs_host() {
                return is_host;
            }

            public void setIs_host(String is_host) {
                this.is_host = is_host;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getSrp_id() {
                return srp_id;
            }

            public void setSrp_id(String srp_id) {
                this.srp_id = srp_id;
            }

            public String getSrp_word() {
                return srp_word;
            }

            public void setSrp_word(String srp_word) {
                this.srp_word = srp_word;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getIs_current_comment() {
                return is_current_comment;
            }

            public void setIs_current_comment(String is_current_comment) {
                this.is_current_comment = is_current_comment;
            }

            public String getIshot() {
                return ishot;
            }

            public void setIshot(String ishot) {
                this.ishot = ishot;
            }

            public String getAppname() {
                return appname;
            }

            public void setAppname(String appname) {
                this.appname = appname;
            }

            public String getIdentity() {
                return identity;
            }

            public void setIdentity(String identity) {
                this.identity = identity;
            }

            public String getReplyListSize() {
                return replyListSize;
            }

            public void setReplyListSize(String replyListSize) {
                this.replyListSize = replyListSize;
            }

            public String getReplyTotalSize() {
                return replyTotalSize;
            }

            public void setReplyTotalSize(String replyTotalSize) {
                this.replyTotalSize = replyTotalSize;
            }

            public List<?> getImages() {
                return images;
            }

            public void setImages(List<?> images) {
                this.images = images;
            }

            public List<?> getReplyList() {
                return replyList;
            }

            public void setReplyList(List<?> replyList) {
                this.replyList = replyList;
            }
        }
    }
}
