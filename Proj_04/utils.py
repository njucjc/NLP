import torch

def argmax(vec):
    # return the argmax as a python int
    _, idx = torch.max(vec, 1)
    return idx.item()


def prepare_sequence(seq, to_ix):
    idxs = [to_ix[w] for w in seq]
    return torch.tensor(idxs, dtype=torch.long)

def prepare_tags(tags, to_ix):
    idxs = [to_ix[t] for t in tags]
    return torch.tensor(idxs, dtype=torch.long)


# Compute log sum exp in a numerically stable way for the forward algorithm
def log_sum_exp(vec):
    max_score = vec[0, argmax(vec)]
    max_score_broadcast = max_score.view(1, -1).expand(1, vec.size()[1])
    return max_score + \
        torch.log(torch.sum(torch.exp(vec - max_score_broadcast)))

def load_dict(path):
    word_to_ix = {}
    with open(path, 'r') as fp:
        words = fp.readlines()
        for word in words:
            word = word.replace('\n', '')
            word_to_ix[word] = len(word_to_ix)
        fp.close()
    return word_to_ix

def load_training_data(path):
    training_data = []
    with open(path, 'r') as fp:
        lines = fp.readlines()
        for line in lines:
            line = line.replace('\n', '')
            elems = line.split(' ')
            words = []
            tags = []
            for e in elems:
                w, t = e.split('/')
                words.append(w)
                tags.append(t)
            training_data.append((words, tags))
        fp.close()
    return training_data

def gen_ix_to_tag(tag_to_ix):
    ix_to_tag = {}
    for (tag, ix) in tag_to_ix:
        ix_to_tag[ix] = tag
    return ix_to_tag

def ix_to_tag_helper(ix, to_tag):
    return [to_tag[i] for i in ix]