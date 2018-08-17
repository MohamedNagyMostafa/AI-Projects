import matplotlib.pyplot as plt

size_data=[2104,1600,2400,1416,3000,1985,1534,1427,
	1380,1494,1940,2000,1890,4478,1268,2300,
	1320,1236,2609,3031,1767,1888,1604,1962,
	3890,1100,1458,2526,2200,2637,1839,1000,
	2040,3137,1811,1437,1239,2132,4215,2162,
	1664,2238,2567,1200,852,1852,1203]

price_data=[399900,329900,369000,232000,539900,299900,314900,198999,
	212000,242500,239999,347000,329999,699900,259900,449900,
	299900,199900,499998,599000,252900,255000,242900,259900,
	573900,249900,464500,469000,475000,299900,349900,169900,
	314900,579900,285900,249900,229900,345000,549000,287000,
	368500,329900,314000,299000,179900,299900,239500]

def training(repeating, w0, w1, training_rate):
	estimatedError = []
	while(repeating > 0):
		prediction = predict(w0, w1)
		wn0 = w0 + 2*training_rate *(
			sum(
				[ye - yp for ye, yp in zip(
					price_data,
					prediction
					)
				]
			)
		)
		wn1 = w1 + 2*training_rate *(
			sum(
				[(ye - yp) * x for ye, yp, x in zip(
					price_data,
					prediction,
					size_data
					)
				]
			)
		)
		estimatedError.append(sum([(ye-yp)**2 for ye, yp in zip(price_data, prediction)]))
		repeating = repeating - 1
		w0 = wn0
		w1 = wn1
	print(w0,w1)
	draw(prediction, repeating)
	drawLoss(estimatedError)

def predict(w0, w1):
	return [w1 * x + w0 for x in size_data]

def draw(prediction, repeating):
	plt.title("prediction")
	plt.xlabel('Size (ft)')
	plt.ylabel('Price (Euro)')
	plt.scatter(size_data, price_data, color="green")
	plt.plot(size_data, prediction, color="red")
	plt.axis([0,max(size_data), min(price_data), max(price_data)])
	plt.show()

def drawLoss(estimateError):
	plt.title("loss")
	plt.xlabel('training')
	plt.ylabel('loss')
	plt.plot(estimateError, color="red")
	print(min(estimateError))
	plt.axis([0, len(estimateError), 0, max(estimateError)])
	plt.show()

training(1000000,0,0, 0.01*10**-7)