# Conversor Binário/Decimal/Hexadecimal
# Solução menos eficiente que as normalmente encontradas na internet, eu tentei fazer com que o programa resolvesse o problema do jeito que um humano resolveria, ou seja, ineficientemente.

def BinToDec(bin):
    reverso = bin[::-1]
    resposta = 0
    valor = 1
    for n in reverso:
        if int(n) == 1:
            resposta += valor
        valor *= 2
    return resposta

def BinToHex(bin):
    reverso = bin[::-1]
    resposta = ""
    quatros = [reverso[i:i+4] for i in range(0, len(reverso), 4)]
    for q in quatros:
        numero = 48
        valor = 1
        for n in q:
            if int(n) == 1:
                numero += valor
            valor *= 2
        if numero >= 58:
            numero += 7
        resposta += chr(numero)
    resposta = resposta[::-1]
    return resposta

def DecToBin(dec):
    tabela = [2,1]
    while (dec % tabela[0]) != dec:
        tabela.insert(0, tabela[0] * 2)
    tabela.pop(0)

    resposta = ""
    resto = dec
    for i in tabela:
        if resto >= i:
            resposta += '1'
        else:
            resposta += '0'
        resto = resto % i
    return "{:0>4}".format(resposta)

def DecToHex(dec):
    binario = DecToBin(dec)
    return BinToHex(binario)

def HexToBin(hex):
    reverso = hex[::-1]
    resposta = ""
    for n in reverso:
        numero = ord(n) - 48
        if numero >= 10:
            numero -= 7
        resposta += DecToBin(numero)[::-1]
    return resposta[::-1]

def HexToDec(hex):
    binario = HexToBin(hex)
    return BinToDec(binario)


print("\n******************* Conversor Binário/Decimal/Hexadecimal *******************")

print("\n1 - Binário -> Decimal\n2 - Binário -> Hexadecimal\n3 - Decimal -> Binário\n4 - Decimal -> Hexadecimal\n5 - Hexadecimal -> Binário\n6 - Hexadecimal -> Decimal")

operacao = int(input("\nDigite a operação desejada (1/2/3/4/5/6): "))

if operacao == 1:
    numero = input("\nDigite o número binário que quer converter pra decimal: ")
    print("\n{} em decimal é: {}".format(numero, BinToDec(numero)))

elif operacao == 2:
    numero = input("\nDigite o número binário que quer converter pra hexadecimal: ")
    print("\n{} em hexadecimal é: {}".format(numero, BinToHex(numero)))

elif operacao == 3:
    numero = int(input("\nDigite o número decimal que quer converter pra binário: "))
    print("\n{} em binário é: {}".format(numero, DecToBin(numero)))

elif operacao == 4:
    numero = int(input("\nDigite o número decimal que quer converter pra hexadecimal: "))
    print("\n{} em hexadecimal é: {}".format(numero, DecToHex(numero)))

elif operacao == 5:
    numero = input("\nDigite o número hexadecimal que quer converter pra binário: ")
    print("\n{} em binário é: {}".format(numero, HexToBin(numero)))

elif operacao == 6:
    numero = input("\nDigite o número hexadecimal que quer converter pra decimal: ")
    print("\n{} em decimal é: {}".format(numero, HexToDec(numero)))

else:
    print("\nOpção Inválida!")