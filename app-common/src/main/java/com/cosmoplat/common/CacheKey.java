package com.cosmoplat.common;

/**
 * @author 27279
 */

public enum CacheKey {

    /**
     * 缓存key例子;
     */
    EXAMPLE_REDIS_KEY(SysConstants.SYS_CODE + "_redis_key_%s",60 * 10),;

    private String key;
    private int term;

    CacheKey(String key, int term) {
        this.key = key;
        this.term = term;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
