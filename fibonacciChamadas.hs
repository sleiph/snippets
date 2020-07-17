main :: IO ()

fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n =
  do
    fibonacci (n-1) + fibonacci (n-2)

main = 
  do
    linha <- readLn :: IO Int
    let e = fibonacci (linha-1)
    let f = fibonacci linha
    putStrLn $ id ("Fib(" ++ show(linha) ++ ") = " ++ show(f) ++ " / " ++show((2*f-1)+(2*e-1)) ++ " chamadas.")