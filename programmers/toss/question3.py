def solution(amountText):
    
    if not amountText.replace(",", "").isdigit():
        return False
    
    if (len(amountText) > 1 and amountText[0] == '0') or amountText[0] == ',':
        return False
    
    if ',' not in amountText:
        return True
    
    for idx, number in enumerate(amountText.split(",")):
        if idx == 0:
            if len(number) <= 3:
                continue
            
        if len(number) != 3:
            return False
    
    return True