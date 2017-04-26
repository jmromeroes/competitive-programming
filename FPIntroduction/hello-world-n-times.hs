import System.IO

helloWorlds :: Int -> IO ()
helloWorlds n | n == 0 = return ()
              | otherwise = do 
                           putStrLn "Hello World"
                           helloWorlds (n - 1)

main :: IO ()
main = do
    n_temp <- getLine
    let n = read n_temp :: Int
    helloWorlds n 



