module type tINDICATEURS = sig
  type contrat = float * float * int (*taux horaires, supplement horaires, heures par jour*)
  type historique = int * int * int * int (* nombre d'heures d'absence, nombre de jours de conge, nombre de jours de maladie, nombre de jours dans la période *)
  type employe = contrat * historique

  val salaire : employe -> float
  val taux_abs : employe -> float
  val cout_horraire : employe -> float
  val taux_abs_conge : employe -> float
  val taux_abs_maladie : employe -> float
  val utilisation_conge : employe -> float
end

module INDICATEURS : tINDICATEURS = struct
  type contrat = float * float * int
  type historique = int * int * int * int
  type employe = contrat * historique

  let salaire (contrat, historique) = let (taux_horaire, sup_horaire, heures_par_jour) = contrat in
                                        let (absence, _, _, jours) = historique in
                                        (taux_horaire +. sup_horaire) *. float_of_int ((heures_par_jour * jours) - absence)
  let taux_abs (contrat, historique) = let (_, _, heures_par_jour) = contrat in
                                        let (absence, _, _, jours) = historique in
                                        ((float_of_int absence) /. (float_of_int (jours * heures_par_jour))) *. 100.
  let cout_horraire (contrat, historique) = let (_, _, heures_par_jour) = contrat in
                                        let (_, _, _, jours) = historique in
                                        ((salaire (contrat, historique)) *. 1.75) /. float_of_int (heures_par_jour * jours)
  let taux_abs_conge (contrat, historique) = let (_, conge, _, jours) = historique in
                                        ((float_of_int conge) /. (float_of_int jours)) *. 100.
  let taux_abs_maladie (contrat, historique) = let (_, _, maladie, jours) = historique in
                                        ((float_of_int maladie) /. (float_of_int jours)) *. 100.
  let utilisation_conge (contrat, historique) = let (_, conge, _, _) = historique in
                                        ((float_of_int conge) /. 30.) *. 100.
end