import data as dt
import util as utl
from cluster import Cluster

def randomPosition(cluster, min_x, max_x, min_y, max_y, min_z, max_z):
	if(cluster.isEmpty()):
		cluster.position =  utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)

def k_means(points, min_x, max_x, min_y, max_y, min_z, max_z):
	pos1 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)
	pos2 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)
	pos3 = utl.randomPosition(min_x, min_y, min_z, max_x, max_y, max_z)

	cluster1 = Cluster(pos1, 'r')
	cluster2 = Cluster(pos2, 'g')
	cluster3 = Cluster(pos3, 'b')

	changed = True

	while(changed):
		changed = False

		while(cluster1.isEmpty() or cluster2.isEmpty() or cluster3.isEmpty()):
			cluster1.clear()
			cluster2.clear()
			cluster3.clear()


			for point in points:
				cluster = utl.closerCluster3D(cluster1, cluster2, cluster3, point)
				cluster.addPoint(point)
			
			randomPosition(cluster1, min_x, max_x, min_y, max_y, min_z, max_z)
			randomPosition(cluster2, min_x, max_x, min_y, max_y, min_z, max_z)
			randomPosition(cluster3, min_x, max_x, min_y, max_y, min_z, max_z)

		utl.draw(cluster1, cluster2, cluster3)

		cluster1.centralize();
		cluster2.centralize();
		cluster3.centralize();

		utl.draw(cluster1, cluster2, cluster3)

		for point in points:
			cluster = utl.closerCluster3D(cluster1, cluster2, cluster3, point)
			print("after center")
			if(not cluster.hasPoint(point)):
				print("changed")
				changed = True
				cluster1.clear()
				cluster2.clear()
				cluster3.clear()
				break;


	print("cluster 1:")
	for point in cluster1.points:
		print("x: ", point.x, " y: ", point.y, " z: ", point.z)
	print("cluster 2:")
	for point in cluster2.points:
		print("x: ", point.x, " y: ", point.y, " z: ", point.z)
	print("cluster 3:")
	for point in cluster3.points:
		print("x: ", point.x, " y: ", point.y, " z: ", point.z)
	utl.draw(cluster1, cluster2, cluster3)


k_means(dt.points, dt.min_x, dt.max_x, dt.min_y, dt.max_z, dt.min_z, dt.max_z)