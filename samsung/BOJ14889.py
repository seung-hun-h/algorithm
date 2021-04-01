from sys import stdin
readline = stdin.readline

def get_perms(start, team):
    if len(team) == N // 2:
        cal_stat(team)
        return

    for i in range(start, len(people)):
        person = people[i]
        people.remove(person)
        get_perms(i, team + [person])
        people.insert(i, person)


def cal_stat(team):
    global _min_gap
    cur = 0
    for i in range(len(team)-1):
        for j in range(i+1, len(team)):
            cur += (_map[team[i]][team[j]] + _map[team[j]][team[i]]) - (_map[people[i]][people[j]] + _map[people[j]][people[i]])

    _min_gap = min(_min_gap, abs(cur))

    
if __name__ == '__main__':
    N = int(readline())
    _map = [list(map(int, readline().split())) for _ in range(N)]
    people = [i for i in range(N)]

    _min_gap = 100 * N**2 + 1
    get_perms(0, [])
    print(_min_gap)