package org.opencms.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CmsLog {
	private CmsLog() {
	}

	public static Log getLog(Object obj) {
		if (obj instanceof String)
			return LogFactory.getLog((String) obj);
		if (obj instanceof Class)
			return LogFactory.getLog((Class) obj);
		else
			return LogFactory.getLog(obj.getClass());
	}

}
