from data_utils import encode
from loader import load_file_content, dump_to_file

train = load_file_content('data/original/train.txt')
dev = load_file_content('data/original/dev.txt')
train_data = encode(train)

dump_to_file(train_data, 'data/example.train', 'w')
dump_to_file(dev_data, 'data/example.dev', 'w')
dump_to_file(dev_data, 'data/example.test', 'w')