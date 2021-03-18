import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import sklearn
from sklearn.datasets import fetch_openml

mnist = fetch_openml(name='mnist_784', version=1)
X,y = mnist['data'], mnist['target']
X, y = X[:70000], y[:70000]

some_digit = X[0]
some_digit_image = some_digit.reshape(28, 28)

plt.imshow(some_digit_image, cmap='binary')
plt.axis('off')
plt.show()