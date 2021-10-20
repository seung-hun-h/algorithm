def solution(money, minratio, maxratio, ranksize, threshold, months):
    for _ in range(months):
        assume_money = remove_under_hundred(money) # 소유 가정 금액
        tax_ratio = 0
        if assume_money >= threshold:
            tax_ratio = (assume_money - threshold) // ranksize + minratio
        
        tax_ratio = maxratio if tax_ratio > maxratio else tax_ratio # 최대 세율

        tax = int(assume_money * tax_ratio / 100)
        money -= tax

    print(money)
    return money

def remove_under_hundred(money):
    return money - money%100


solution(0, 10, 20, 250000, 10000000, 4)