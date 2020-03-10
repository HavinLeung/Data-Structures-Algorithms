open! Core

let rec last : ('a list -> 'a option) = function
  | [] -> None
  | [hd] -> Some hd
  | (_hd : 'a) :: tl -> last tl
;;

let%expect_test _ =
  print_s [%message (last [] : int option)];
  [%expect {| ("last []" ()) |}];
  print_s [%message (last [1] : int option)];
  [%expect {| ("last [1]" (1)) |}];
  print_s [%message (last [1;2;3;4] : int option)];
  [%expect {| ("last [1; 2; 3; 4]" (4)) |}]
;;

let rec last_two : ('a list -> ('a * 'a) option) = function
  | [] | [(_ : 'a)] -> None
  | [a; b] -> Some (a,b)
  | (_ : 'a) :: tl -> last_two tl
;;

let%expect_test _ =
  print_s [%message (last_two [] : (int * int) option)];
  [%expect {| ("last_two []" ()) |}];
  print_s [%message (last_two [1] : (int * int) option)];
  [%expect {| ("last_two [1]" ()) |}];
  print_s [%message (last_two [1;2] : (int * int) option)];
  [%expect {| ("last_two [1; 2]" ((1 2))) |}];
  print_s [%message (last_two [1;2;3] : (int * int) option)];
  [%expect {| ("last_two [1; 2; 3]" ((2 3))) |}];
  print_s [%message (last_two [1;2;3;4] : (int * int) option)];
  [%expect {| ("last_two [1; 2; 3; 4]" ((3 4))) |}];
;;
