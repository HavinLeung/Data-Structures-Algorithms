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

let rev some_list =
  let rec rev acc = function
    | [] -> acc
    | hd :: tl -> rev (hd::acc) (tl)
  in
  rev [] some_list
;;

let%expect_test _ =
  print_s [%message (rev [] : int list)];
  [%expect {| ("rev []" ()) |}];
  print_s [%message (rev [1] : int list)];
  [%expect {| ("rev [1]" (1)) |}];
  print_s [%message (rev [1;2] : int list)];
  [%expect {| ("rev [1; 2]" (2 1)) |}];
  print_s [%message (rev [1;2;3;4] : int list)];
  [%expect {| ("rev [1; 2; 3; 4]" (4 3 2 1)) |}];
;;

type 'a node =
  | One of 'a
  | Many of 'a node list
;;

let flatten nodes =
  (* flattens in reverse order *)
  let rec rev_flatten accum nodes =
    match nodes with
    | [] -> accum
    | One hd :: tl -> rev_flatten (hd :: accum) tl
    | Many lists :: tl -> rev_flatten (rev_flatten accum lists) tl
  in
  rev_flatten [] nodes |> rev
;;

let%expect_test _ =
  print_s [%message (flatten [] : int list)];
  [%expect {| ("flatten []" ()) |}];
  print_s [%message (flatten [One 1; One 2; One 3] : int list)];
  [%expect {| ("flatten [One 1; One 2; One 3]" (1 2 3)) |}];
  print_s [%message (flatten ([Many [One 1; Many [ One 2; Many [One 3]]]]) : int list)];
  [%expect {| ("flatten [Many [One 1; Many [One 2; Many [One 3]]]]" (1 2 3)) |}];
  print_s [%message (flatten ([Many [One 1; Many [ One 2; Many [One 3; One 4; One 5; Many [One 6; One 7]; One 8]]]]) : int list)];
  [%expect {|
    ( "flatten\
     \n  [Many\
     \n     [One 1;\
     \n     Many [One 2; Many [One 3; One 4; One 5; Many [One 6; One 7]; One 8]]]]"
     (1 2 3 4 5 6 7 8)) |}];

;;

let compress mlist =
  let rec compress cur acc = function
    | [] -> rev acc
    | hd :: tl -> if cur = hd then compress cur acc tl else compress hd (hd :: acc) tl
  in
  match mlist with
  | [] -> []
  | hd :: tl -> compress hd [hd] tl
;;

let%expect_test _ =
  print_s [%message (compress [1; 1; 1; 1; 1; 1; 1; 1; 1; 1; 1]: int list)];
  [%expect {| ("compress [1; 1; 1; 1; 1; 1; 1; 1; 1; 1; 1]" (1)) |}];
  print_s [%message (compress [1; 1; 2; 2; 2; 3; 3; 4; 4; 5; 6]: int list)];
  [%expect {| ("compress [1; 1; 2; 2; 2; 3; 3; 4; 4; 5; 6]" (1 2 3 4 5 6)) |}];
  print_s [%message (compress [1; 1; 2; 2; 2; 3; 3; 2; 3; 2; 2]: int list)];
  [%expect {| ("compress [1; 1; 2; 2; 2; 3; 3; 2; 3; 2; 2]" (1 2 3 2 3 2)) |}];
;;

let pack mlist =
  let rec pack cur acc = function
    | a :: b :: tl -> if a = b then pack (a :: cur) acc (b :: tl) else pack [] ((a :: cur) :: acc) (b :: tl)
    | [hd] -> (hd :: cur) :: acc
    | [] -> acc
  in
  pack [] [] mlist |> rev
;;

let%expect_test _ =
  print_s [%message (pack [1;1;1;2;2;3]: int list list)];
  [%expect {| ("pack [1; 1; 1; 2; 2; 3]" ((1 1 1) (2 2) (3))) |}];
  print_s [%message (pack []: int list list)];
  [%expect {| ("pack []" ())|}];
  print_s [%message (pack [1;2;3;4;5;6]: int list list)];
  [%expect {| ("pack [1; 2; 3; 4; 5; 6]" ((1) (2) (3) (4) (5) (6))) |}];
;;
