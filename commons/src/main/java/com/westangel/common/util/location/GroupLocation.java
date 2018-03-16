package com.westangel.common.util.location;

import java.util.List;
import java.util.Set;

public class GroupLocation {
	public String grpid;
	public Set<Location> data;
	public Location center;
	
	public GroupLocation(String groupId, Set<Location> set) {
		grpid = groupId;
	    data = set;
	}

	public Location center() {
		if (center == null) {
			double latitude = 0;
			double longtitude = 0;
			for (Location item : data) {
				latitude += item.getX();
				longtitude += item.getY();
			}
			latitude = latitude / data.size();
			longtitude = longtitude / data.size();
			center = new Location();
			center.setX(latitude);
			center.setY(longtitude);
			center.setData(grpid);
		}
		return center;
	}
	
	public String getGrpid() {
		return grpid;
	}

	public void setGrpid(String grpid) {
		this.grpid = grpid;
	}

	public Set<Location> getData() {
		return data;
	}

	public void setData(Set<Location> data) {
		this.data = data;
	}

	public static GroupLocation getNearestGroup(Location loc, List<GroupLocation> grpList) {
		double distance = Double.MAX_VALUE;
		GroupLocation ret = null;
		for (GroupLocation grp : grpList) {
			Location center = grp.center();
			double newDistance = Location.getDistance(loc, center);
			if (newDistance < distance) {
				distance = newDistance;
				ret = grp;
			}
		}
		return ret;
	}
}
