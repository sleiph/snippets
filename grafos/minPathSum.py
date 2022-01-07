def minPathSum(matriz):
  n = len(matriz)
  m = len(matriz[0])

  for j in range(1, m):
    matriz[0][j] = matriz[0][j-1]+matriz[0][j]

  for i in range(1, n):
    matriz[i][0] = matriz[i-1][0] + matriz[i][0]

  for i in range (1, n):
    for j in range(1, m):
      matriz[i][j] += min(matriz[i-1][j], matriz[i][j-1])

  return matriz[n-1][m-1]
