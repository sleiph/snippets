def calcMemoria(cc, nc):
    return int(cc) * int(nc)

def calcCelula(cm, nc):   
    return int(cm) / int(nc)

def calcX(n):
    x = 0
    while n > 1:
        n /= 2
        x += 1
    return x

def calcNCel(x, cm, cc):
    return 2 ** int(x) if x != "" else int(cm) / int(cc)

print("Calculadora de Capacidade de Memória RAM")
print("Deixe os campos que não souber em branco e eles serão calculados.")
while True:
    print("\nInforme pelo menos um dos valores a seguir:")
    cm = input('Capacidade da memória em bits: ')
    cc = input('\nCapacidade da célula em bits: ')
    if cm != "" or cc != "":
        break
    print("\nPelo menos um desses dois valores deve ser informado.")
    
if cm == "" or cc == "":
    while True:
        print("\n\nInforme também pelo menos um dos valores a seguir:")
        x = input('Tamanho do endereço em bits: ')
        nc = input('\nNúmero de células: ')
        if x != "" or nc != "":
            break
        print("\nPelo menos um desses dois valores deve ser informado.")
else:
    print("\nNão precisa preencher os valores seguintes:")
    x = input('Tamanho do endereço em bits: ')
    nc = input('\nNúmero de células: ')

valNC = nc if nc != "" else calcNCel(x, cm, cc)
valX = x if x != "" else calcX(int(valNC))

valCel = cc if cc != "" else calcCelula(cm, valNC)
valMem = cm if cm != "" else calcMemoria(valCel, valNC)

print("\n\nCapacidade da memória: {} bits, ou {:,} bytes".format(valMem, int(valMem)/8))
print("Capacidade da célula: {0} bits, ou {1} bytes".format(valCel, int(valCel)/8))
print("Tamanho do endereço: {0} bits".format(valX))
print("Número de células: {0}/ 2^{1}".format(valNC, valX))