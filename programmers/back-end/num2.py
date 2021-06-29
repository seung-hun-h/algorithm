from collections import defaultdict
def solution(enroll, referral, sellers, amounts):
    organization = build_reverse_tree(enroll, referral)
    profits = defaultdict(int)

    for seller, amount in zip(sellers, amounts):
        spread_profit(organization, profits, seller, amount*100)

    return [profits[person] for person in enroll]

def spread_profit(parent, profits, person, amount):
    if amount < 10:
        profits[person] += amount
        return

    spreaded = amount // 10
    profit = amount - spreaded
    profits[person] += profit
    spread_profit(parent, profits, parent[person], spreaded)

def build_reverse_tree(children, parents):
    tree = defaultdict(str)

    for parent, child in zip(parents, children):
        tree[child] = parent

    return tree
