def nCombinacoes(resultado, elementos):
    if resultado < 0:
        return 0
    if not elementos:
        return 0

    dp = [0] * (resultado + 1)
    dp[0] = 1
    for i in range(0, len(elementos)):
        for j in range(elementos[i], resultado+1):
            dp[j] += dp[j - elementos[i]]
    return dp[resultado]

# Driver
if __name__ == "__main__":
    resultado = 200
    moedas = [200, 100, 50, 20, 10, 5, 2, 1]

    nCombinacoes(resultado, moedas)
