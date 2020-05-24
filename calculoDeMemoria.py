print("\nDeixe os campos que não souber em branco e eles serão calculados.")

# Declaração das variáveis conhecidas
cm = input('\nCapacidade da memória em bits: ')
cc = input('Capacidade da célula em bits: ')
x = input('Tamanho do endereço em bits: ')
nc = input('Número de células: ')

if cm == "" and cc == "":
    print("\nPelo menos uma das capacidades (cm ou cc) precisa ser informada.")

else:
    # Cálculo de numero de células sem o tamanho do endereço:
    if nc == "" and x == "" and cm != "" and cc != "":
        nc = int(cm) / int(cc)

    # Cálculo de x:
    if nc != "" and x == "":
        iteracao = int(nc)
        x = 1
        while iteracao > 2:
            iteracao /= 2
            x += 1

    # Cálculo de capacidade da memória:
    if cm == "":
        if nc == "":
            nc = 2 ** int(x)
        cm = int(cc) * int(nc)

    # Cálculo de capacidade da célula:
    elif cc == "":
        if nc == "":
            nc = 2 ** int(x)
        cc = int(cm) / int(nc)

    print("\nCapacidade da memória: {} bits/ {:,} bytes".format(cm, int(cm)/8))
    print("Capacidade da célula: {} bits/ {} bytes".format(cc, int(cc)/8))
    print("Tamanho do endereço: {} bits".format(x))
    print("Número de células: {}/ 2^{}".format(int(nc), x))