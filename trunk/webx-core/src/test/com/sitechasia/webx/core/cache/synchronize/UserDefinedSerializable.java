package com.sitechasia.webx.core.cache.synchronize;

import java.io.Serializable;

public class UserDefinedSerializable implements Serializable {
	public String name;
	public String nickname;

	
	
	public UserDefinedSerializable(String name, String nickname) {
	    this.name = name;
	    this.nickname = nickname;
    }
	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
	    result = prime * result
	            + ((nickname == null) ? 0 : nickname.hashCode());
	    return result;
    }
	@Override
    public boolean equals(Object obj) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    final UserDefinedSerializable other = (UserDefinedSerializable) obj;
	    if (name == null) {
		    if (other.name != null)
			    return false;
	    } else if (!name.equals(other.name))
		    return false;
	    if (nickname == null) {
		    if (other.nickname != null)
			    return false;
	    } else if (!nickname.equals(other.nickname))
		    return false;
	    return true;
    }

	
	
}
