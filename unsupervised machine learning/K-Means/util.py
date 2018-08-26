import random as rn
import point
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
import matplotlib
import matplotlib.pyplot as plt

# Set Default position for cluster
def randomPosition(min_x, min_y, min_z, max_x, max_y, max_z):
	x_position = rn.uniform(min_x, max_x +1)
	y_position = rn.randint(min_y, max_y +1)
	z_position = rn.randint(min_z, max_z +1)

	return Point(x_position, y_position, z_position)

# calculate the euclidean distance between two points
def distance(point1, point2):
	return ((point1.x - point2.x)**2 + (point1.y - point2.y)**2 + (point1.z - point2.z)**2)**(0.5)

# returns the closest cluster to a specific point
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

# bubble sort
def sort(list):
	for i in range(1, len(list)):
		j = i-1
		while list[j+1] < list[j] and j >= 0:
			swap = list[j]
			list[j] = list[j+1]
			list[j+1] = swap
			j= j-1
	return list

# get median for a list
def median(list):
	list = sort(list)
	size = len(list)
	if(size %2 == 0):
		index = int(size/2)
		return (list[index] + list[index-1])/2
	else:
		index = int((size+1)/2)
		return list[index-1]

def draw(cluster1, cluster2, cluster3):
	fig = plt.figure()
	ax = Axes3D(fig)
# put 0s on the y-axis, and put the y axis on the z-axis
	ax.scatter3D(xs= cluster1.axes['x'], ys=cluster1.axes['y'], zs=cluster1.axes['z'], c=cluster1.color, marker= 'o')
	ax.scatter3D(xs= cluster2.axes['x'], ys=cluster2.axes['y'], zs=cluster2.axes['z'], c=cluster2.color, marker= 'o')
	ax.scatter3D(xs= cluster3.axes['x'], ys=cluster3.axes['y'], zs=cluster3.axes['z'], c=cluster3.color, marker= 'o')
	ax.plot(xs=cluster1.position.x, ys=cluster1.position.x, zs=cluster1.position.x, c=cluster1.color, marker='^')
	ax.plot(xs=cluster2.position.x, ys=cluster2.position.x, zs=cluster2.position.x, c=cluster2.color, marker='^')
	ax.plot(xs=cluster3.position.x, ys=cluster3.position.x, zs=cluster3.position.x, c=cluster3.color, marker='^')

	plt.show()