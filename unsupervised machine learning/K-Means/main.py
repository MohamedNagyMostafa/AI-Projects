import data as dt
import util as utl
import cluster as Cluster


def randomPosition(cluster, min_x, max_x, min_y, max_y, min_z, max_z):
	if(cluster.isEmpty()):
		cluster.position =  utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)

def k_means(points, min_x, max_x, min_y, max_y, min_z, max_z):
	pos1 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)
	pos2 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)
	pos3 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)

	cluster1 = Cluster(pos1)
	cluster2 = Cluster(pos2)
	cluster3 = Cluster(pos3)

	changed = true

	while(changed):
		changed = false

		while(not cluster1.isEmpty() and not cluster2.isEmpty() and not cluster3.isEmpty()):
			cluster1.clear()
			cluster2.clear()
			cluster3.clear()


			for point in points:
				cluster = utl.closerCluster3D(cluster1, cluster2, cluster3, point)
				cluster.addPoint(point)
			
			randomPosition(cluster1, min_x, max_x, min_y, max_y, min_z, max_z)
			randomPosition(cluster2, min_x, max_x, min_y, max_y, min_z, max_z)
			randomPosition(cluster3, min_x, max_x, min_y, max_y, min_z, max_z)


		cluster1.centralize();
		cluster2.centralize();
		cluster3.centralize();

		for point in points:
			cluster = utl.closerCluster3D(cluster1, cluster2, cluster3, point)
			if(not cluster.hasPoint(point)):
				changed = true
				break;
		utl.draw(cluster1, cluster2, cluster3)

k_means(dt.points, dt.min_x, dt.max_x, dt.min_y, dt.max_z, dt.min_z, dt.max_z)