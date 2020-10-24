--Given a text return a tuple of each word containing the repetitions and the word.
import qualified Data.Char as Char
import qualified Data.Map as Map

addWord :: String -> Map.Map String Int -> Map.Map String Int
addWord str m =
  Map.insert str ((Map.findWithDefault 0 str m) + 1) m
   
wordRepetitions :: String -> [(Int, String)]
wordRepetitions str = map (\(a,b) -> (b,a)) (Map.assocs resultMap)
  where resultMap = foldr (\curr acc ->  addWord curr acc) Map.empty (words str)

main :: IO ()
main = do
  putStrLn $ show $ wordRepetitions "This is a is test test"
