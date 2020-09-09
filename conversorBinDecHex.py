# Conversor Binário/Decimal/Hexadecimal
# Solução menos eficiente que as normalmente encontradas na internet, eu tentei fazer com que o programa resolvesse o problema do jeito que um humano resolveria, ou seja, ineficientemente.

def BinToDec(bin):
    resposta = 0
    reverso = bin[::-1]
    valor = 1
    for n in reverso:
        if int(n) == 1:
            resposta += valor
        valor *= 2
    return resposta

def BinToHex(bin):
    resposta = ""
    quatros = [bin[::-1][i:i+4] for i in range(0, len(bin), 4)]
    for q in quatros:
        numero = 48
        valor = 1
        for n in q:
            numero += valor if int(n) == 1 else 0
            valor *= 2
        numero += 7 if numero >= 58 else 0
        resposta += chr(numero)
    resposta = resposta[::-1]
    return resposta

def DecToBin(dec):
    resposta = ""
    resto, i = dec, 1
    while resto // 2:
        i *= 2
        resto /= 2
    resto = dec
    while (i > 0):
        resposta += '1' if resto >= i else '0'
        resto %= i
        i = i // 2
    return resposta

def DecToHex(dec):
    binario = DecToBin(dec)
    return BinToHex(binario)

def HexToBin(hex):
    resposta = ""
    i = int(hex, 16)
    while i > 0:
        resposta += str(i%2)
        i = i >> 1
    return resposta[::-1]

def HexToDec(hex):
    binario = HexToBin(hex)
    return BinToDec(binario)

def conversor(n):
    if n>=1 and n<=6:
        numero = input("\nDigite o número que quer converter: ").replace(' ', '')
        if n == 1:
            print("\n{} em decimal é: {}".format(numero, BinToDec(numero)))
        elif n == 2:
            print("\n{} em hexadecimal é: {}".format(numero, BinToHex(numero)))
        elif n == 3:
            print("\n{} em binário é: {}".format(int(numero), DecToBin(int(numero))))
        elif n == 4:
            print("\n{} em hexadecimal é: {}".format(int(numero), DecToHex(int(numero))))
        elif n == 5:
            print("\n{} em binário é: {}".format(numero, HexToBin(numero)))
        elif n == 6:
            print("\n{} em decimal é: {}".format(numero, HexToDec(numero)))
        return True
    else: return False

print("\n******************* Conversor Binário/Decimal/Hexadecimal *******************")
print("\n1 - Binário -> Decimal")
print("2 - Binário -> Hexadecimal")
print("3 - Decimal -> Binário")
print("4 - Decimal -> Hexadecimal")
print("5 - Hexadecimal -> Binário")
print("6 - Hexadecimal -> Decimal\n")
while True:
    operacao = int(input("Digite a operação desejada (1/2/3/4/5/6): "))
    if conversor(operacao):
        break
    print("Opção Inválida!")