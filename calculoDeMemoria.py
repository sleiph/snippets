calculavel = True

print("\nDeixe os campos que não souber em branco e eles serão calculados.")

# Declaração das variáveis conhecidas
cm = input('\nCapacidade da memória em bits: ')
cc = input('Capacidade da célula em bits: ')
x = input('Tamanho do endereço em bits: ')
nc = input('Número de células: ')

# Cálculo de tamanho do endereço:
def calculoDeX(n):
    x = 1
    while n > 2:
        n /= 2
        x += 1
    return x

if cm == "" and cc == "":
    print("\nPelo menos uma das capacidades (cm ou cc) precisa ser informada.")
    calculavel = False

# Cálculo de capacidade da memória:
elif cm == "" and cc != "":
    if nc == "" and x == "":
        calculavel = False
    elif x == "" and nc != "":
        x = calculoDeX(int(nc))
        cm = int(cc) * int(nc)
    else:
        nc = 2 ** int(x)
        cm = int(cc) * int(nc)
        
# Cálculo de capacidade da célula:    
elif cm != "" and cc == "":
    if nc == "" and x == "":
        calculavel = False
    elif x == "" and nc != "":
        x = calculoDeX(int(nc))
        cc = int(cm) / int(nc)
    else:
        nc = 2 ** int(x)
        cc = int(cm) / int(nc)
    
else:
    # Cálculo de numero de células sem o tamanho do endereço:
    if nc == "" and x == "":
        nc = int(cm) / int(cc)
        x = calculoDeX(int(nc))
      
    elif x != "" and nc == "":
        nc = 2 ** int(x)
        
    else:
        x = calculoDeX(int(nc))

if calculavel == False:
    print("\nPelo menos duas variáveis precisam ser informadas.")
else:        
    print("\nCapacidade da memória: {} bits/ {:,} bytes".format(cm, int(cm)/8))
    print("Capacidade da célula: {} bits/ {} bytes".format(cc, int(cc)/8))
    print("Tamanho do endereço: {} bits".format(x))
    print("Número de células: {}/ 2^{}".format(int(nc), x))