START_TAG = "<START>"
STOP_TAG = "<STOP>"
EMBEDDING_DIM = 5
HIDDEN_DIM = 4

tag_to_ix = {
    'O': 0,
    'B-PERSON': 1,
    'I-PERSON': 2,
    'O-PERSON': 3,
    'B-TIME': 4,
    'I-TIME': 5,
    'O-TIME': 6,
    'B-ORGANIZATION': 7,
    'I-ORGANIZATION': 8,
    'O-ORGANIZATION': 9,
    'B-LOCATION': 10,
    'I-LOCATION': 11,
    'O-LOCATION': 12,
    START_TAG: 13,
    STOP_TAG: 14
}