import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from zlib import crc32
from sklearn.preprocessing import OrdinalEncoder
from sklearn.preprocessing import OneHotEncoder
from sklearn.impute import SimpleImputer
from sklearn.compose import ColumnTransformer
from sklearn.linear_model import LinearRegression
from sklearn.pipeline import Pipeline

from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.model_selection import StratifiedShuffleSplit


dataset = pd.read_csv('../480/hw2_student_scores.csv')
#dataset.info()
def test_set_check(identifier, test_ratio=0.2):
    total_size = 2**32
    hex_repr = crc32(np.int64(identifier)) & 0xffffffff
    in_test = hex_repr < (test_ratio * total_size)
    return in_test
    
dataset_with_id = dataset.reset_index()

def split_train_test_by_id(data, test_ratio, id_column):
    ids = data[id_column]
    in_test_set = ids.apply(lambda id_: test_set_check(id_, test_ratio))
    return data.loc[~in_test_set], data.loc[in_test_set]

train_set, test_set = split_train_test_by_id(data=dataset_with_id, test_ratio=0.2, id_column="index")


train_set, test_set = train_test_split(dataset, test_size=0.2, random_state=42)
dataset['scores_cat'] = pd.cut(x=dataset['Scores'], bins=[0, 1.5, 3, 4.5, 6, np.inf], labels=[1, 2, 3, 4, 5])

split = StratifiedShuffleSplit(n_splits=1, test_size=0.2, random_state=42)
for train_index, test_index in split.split(X=dataset, y=dataset['scores_cat']):
    strat_train_set = dataset.loc[train_index]
    strat_test_set = dataset.loc[test_index]

dataset.plot(kind='scatter', x='Hours', y='Scores')
plt.show()
dataset['score_per_hour_studied'] = dataset['Scores']/dataset['Hours']
corr_matrix = dataset.corr()
corr_matrix['score_per_hour_studied'].sort_values(ascending=False)

median = dataset['Hours'].median()
dataset['Hours'].fillna(median, inplace=True)

dataset = strat_train_set.drop("Scores", axis=1)
dataset_labels = strat_train_set['Scores'].copy()

for set_ in (strat_train_set, strat_test_set):
    set_.drop('scores_cat', axis=1, inplace=True)
    
imputer = SimpleImputer(strategy='median')
dataset_num = dataset.drop("Gender", axis=1)
imputer.fit(dataset_num)
X = imputer.transform(dataset_num)
dataset_tr = pd.DataFrame(data=X, index=dataset_num.index, columns=dataset_num.columns)

dataset_cat = dataset[['Gender']]
ordinal_encoder = OrdinalEncoder()

dataset_cat_encoded = ordinal_encoder.fit_transform(dataset_cat.values)


one_hot_encoder = OneHotEncoder()
dataset_cat_1hot = one_hot_encoder.fit_transform(dataset_cat.values)

num_pipeline = Pipeline([
    ('imputer', SimpleImputer(strategy='median')),
    ('std_scaler', StandardScaler())
])

num_attribs = dataset_num.columns.tolist()
cat_attribs = ["Gender"]

full_pipeline = ColumnTransformer([
    ("num", num_pipeline, num_attribs),
    ("cat", OneHotEncoder(), cat_attribs)
])
dataset_prepared = full_pipeline.fit_transform(dataset)

lin_reg = LinearRegression()
lin_reg.fit(dataset_prepared, dataset_labels)
some_data = dataset.iloc[:5]
some_labels = dataset_labels.iloc[:5]
some_data_prepared = full_pipeline.transform(some_data)
print("Predictions: ", lin_reg.predict(some_data_prepared))
print("Labels: ", some_labels.tolist())


