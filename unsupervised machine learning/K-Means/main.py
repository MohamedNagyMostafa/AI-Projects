from mpl_toolkits.mplot3d import Axes3D
import numpy as np
import random as rn
import matplotlib
import matplotlib.pyplot as plt

import util as utl
import cluster

#fig = plt.figure()
#ax = Axes3D(fig)

#x = [6]
#y = [3]
# put 0s on the y-axis, and put the y axis on the z-axis
#ax.scatter3D(xs=x, ys=[0], zs=y)
#plt.show()


def k_means(points, min_x, max_x, min_y, max_y, min_z, max_z):
	pos1 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)
	pos2 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)
	pos3 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)
	cluster1 = new Cluster(pos1)
	cluster2 = new Cluster(pos2)
	cluster3 = new Cluster(pos3)

	changed = true

	while(changed):
		changed = false

		cluster1.clear()
		cluster2.clear()
		cluster3.clear()

		for point in points:
			cluster = utl.closerCluster3D(cluster1, cluster2, cluster3, point)
			cluster.addPoint(point)

		cluster1.centralize();
		cluster2.centralize();
		cluster3.centralize();

		for point in points:
			cluster = utl.closerCluster3D(cluster1, cluster2, cluster3, point)
			if(not cluster.hasPoint(point)):
				changed = true
				break;
		utl.draw(cluster1, cluster2, cluster3)



