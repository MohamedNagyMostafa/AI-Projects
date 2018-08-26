import util.py

class cluster:
	def __init__(self, position, color):
		self.position = position
		self.color = color
		self.axes = {'x':[], 'y':[], 'z':[]}

	def distance(self, point):
		return distance(self.position, point)

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
		

		self.position.x = median(self.axes['x'])
		self.position.y = median(self.axes['y'])
		self.position.z = median(self.axes['z'])

	def hasPoint(self, point):
		return point in self.points

	def isEmpty(self):
		return len(self.points) == 0