import util as utl

class Cluster:
	def __init__(self, position, color):
		self.points = []
		self.position = position
		self.color = color
		self.axes = {'x':[], 'y':[], 'z':[]}

	def distance(self, point):
		return utl.distance(self.position, point)

	def clear(self):
		self.points[:] = []

		self.axes['x'][:] = []
		self.axes['y'][:] = []
		self.axes['z'][:] = []

	def addPoint(self, point):
		self.points.append(point)

		self.axes['x'].append(point.x)
		self.axes['y'].append(point.y)
		self.axes['z'].append(point.z)

	def centralize(self):
		
		self.position.x = utl.median(self.axes['x'][:])
		self.position.y = utl.median(self.axes['y'][:])
		self.position.z = utl.median(self.axes['z'][:])

	def hasPoint(self, point):
		print("Test", point.x, point.y, point.z,)
		(print("compare", p.x, p.y, p.z) for p in self.points)
		return point in self.points

	def isEmpty(self):
		return len(self.points) == 0