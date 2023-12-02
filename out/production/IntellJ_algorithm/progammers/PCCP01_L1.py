def solution(bandage, health, attacks):
    max_health = health
    success_cnt = 0
    last_attack_time = attacks[-1][0]
    attacks_dict = {key: value for key, value in attacks}
    casting_time, sec_heal, add_heal = bandage

    for i in range(last_attack_time + 1):
        if i in attacks_dict:
            health -= attacks_dict[i]
            success_cnt = 0

            if health <= 0:
                return -1
        else:
            health += sec_heal
            success_cnt += 1

            if success_cnt == casting_time:
                health += add_heal
                success_cnt = 0

            if health > max_health:
                health = max_health

    return health
