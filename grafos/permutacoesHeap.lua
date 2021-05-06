-- algoritmo de Heap pra permutação de elementos
-- Código original em python por ankush_953
 
-- Função que gera as permutações recursivamente
function HeapPermuta(a, tamanho, n)
    -- quando o tamanho do array vira 1
    -- retorna o array modificado
    if tamanho == 1 then
        print(table.concat(a, ""))
        c = c + 1
        return
    end

    -- enquanto o tamanho for maior que 1
    -- chama a função denovo com um elemento a menos
    for i=1, tamanho do
        HeapPermuta(a, tamanho-1, n)
 
        -- se o tamanho for impar
        -- troca o primeiro elemento com o último
        if tamanho%2 == 1 then
            temp = a[1]
            a[1] = a[tamanho]
            a[tamanho] = temp

        -- senão
        -- troca o elemento atual (i) com o último
        else
            temp = a[i]
            a[i] = a[tamanho]
            a[tamanho] = temp
        end
    end
end

-- driver
print("Digite os elementos serem permutados (separados por espaços):")
entrada = io.read():gmatch("%S+")
-- número de elementos
n = 0
-- número de combinações possíveis
c = 0

a = {}
for substring in entrada do
    n = n+1
    a[n] = substring
end

print()
HeapPermuta(a, n, n)

print(string.format("Estas são as %d combinações possíveis dos elementos digitados.", c))