open Tad_sirh
open Parse_cli


let main = 
  let contract = CDD in
  let string_of_type_contrat c = match c with
    | CDI -> "CDI"
    | CDD -> "CDD"
    | STAGE -> "STAGE" in
  Format.sprintf "Bonjour, je suis un %s !" (string_of_type_contrat contract)

let () = print_string (main)