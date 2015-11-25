package com.tmh.web.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Model层的基础类，最好继承下来
 * @author TianMengHua
 *
 */
public abstract class BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7704453540191330280L;

	@Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
	public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
	public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}