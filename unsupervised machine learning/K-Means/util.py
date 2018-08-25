def distance(point1, point2):
	return ((point1.x - point2.x)**2 + (point1.y - point2.y)**2 + (point1.z - point2.z)**2)**(0.5)

def closerCluster3D(cluster1, cluster2, cluster3, point):
	c1_d = cluser1.distance(point)
	c2_d = cluser2.distance(point)
	c3_d = cluser3.distance(point)

	if(c1_d < c2_d):
		if(c1_d < c3_d):
			return cluster1
		else:
			if(c2_d < c3_d):
				return c2_d
			else:
				return c3_d
	else:
		if(c2_d < c3_d):
			return c2_d
		else:
			return c3_d

def sort(list):
	for i in range(1, len(list)):
		j = i-1
		while list[j+1] < list[j] and j >= 0:
			swap = list[j]
			list[j] = list[j+1]
			list[j+1] = swap
			j= j-1
	return list

def median(list):
	list = sort(list)
	size = len(list)
	if(size %2 == 0):
		index = int(size/2)
		return (list[index] + list[index-1])/2
	else:
		index = int((size+1)/2)
		return list[index-1]
