package com.sea.user.model;

public class UserEntity implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.userId
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    private Long userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.username
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.encryptKey
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    private String encryptkey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.createTime
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    private Long createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.nickname
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.headImgUrl
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    private String headimgurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.gender
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    private Byte gender;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.userId
     *
     * @return the value of t_user.userId
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.userId
     *
     * @param userid the value for t_user.userId
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.username
     *
     * @return the value of t_user.username
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.username
     *
     * @param username the value for t_user.username
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.encryptKey
     *
     * @return the value of t_user.encryptKey
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public String getEncryptkey() {
        return encryptkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.encryptKey
     *
     * @param encryptkey the value for t_user.encryptKey
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public void setEncryptkey(String encryptkey) {
        this.encryptkey = encryptkey == null ? null : encryptkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.createTime
     *
     * @return the value of t_user.createTime
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public Long getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.createTime
     *
     * @param createtime the value for t_user.createTime
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.nickname
     *
     * @return the value of t_user.nickname
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.nickname
     *
     * @param nickname the value for t_user.nickname
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.headImgUrl
     *
     * @return the value of t_user.headImgUrl
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.headImgUrl
     *
     * @param headimgurl the value for t_user.headImgUrl
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.gender
     *
     * @return the value of t_user.gender
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.gender
     *
     * @param gender the value for t_user.gender
     *
     * @mbggenerated Sun Jul 05 20:48:36 CST 2015
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }
}