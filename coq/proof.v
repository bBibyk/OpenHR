From Coq Require Import Lia.
Require Import Arith.
Require Import Coq.Init.Nat.

Module Type tINDICATEURS.
  Parameter contrat : Type.
  Parameter historique : Type.
  Parameter employe : Type.

  Parameter salaire : employe -> nat.
  Parameter taux_abs : employe -> nat.
  Parameter cout_horraire : employe -> nat.
  Parameter taux_abs_conge : employe -> nat.
  Parameter taux_abs_maladie : employe -> nat.
  Parameter utilisation_conge : employe -> nat.
End tINDICATEURS.

Module INDICATEURS <: tINDICATEURS.
  Definition contrat := (nat * nat * nat)%type.
  Definition historique := (nat * nat * nat * nat)%type.
  Definition employe := (contrat * historique)%type.

  Definition salaire (emp : employe) : nat :=
    let '((taux_horaire, sup_horaire, heures_par_jour), (absence, _, _, jours)) := emp in
    (taux_horaire + sup_horaire) * ((heures_par_jour * jours) - absence).

  Definition taux_abs (emp : employe) : nat :=
    let '(_, _, heures_par_jour) := fst emp in
    let '(absence, _, _, jours) := snd emp in
    (absence * 100) / (jours * heures_par_jour).

  Definition cout_horraire (emp : employe) : nat :=
    let '(_, _, heures_par_jour) := fst emp in
    let '(s, _, _, jours) := snd emp in
    (s * 175) / (heures_par_jour * jours).

  Definition taux_abs_conge (emp : employe) : nat :=
    let '(_, conge, _, jours) := snd emp in
    (conge * 100) / jours.

  Definition taux_abs_maladie (emp : employe) : nat :=
    let '(_, _, maladie, jours) := snd emp in
    (maladie * 100) / jours.

  Definition utilisation_conge (emp : employe) : nat :=
    let '(_, conge, _, _) := snd emp in
    (conge * 100) / 30.
End INDICATEURS.

Module INDICATEURSProof.

  Lemma salaire_positive : forall emp : INDICATEURS.employe, INDICATEURS.salaire emp >= 0.
  Proof.
  Admitted.

  Lemma taux_abs_percentage : forall emp : INDICATEURS.employe, INDICATEURS.taux_abs emp <= 100.
  Proof.
  Admitted.

  Lemma cout_horraire_nonneg : forall emp : INDICATEURS.employe, INDICATEURS.cout_horraire emp >= 0.
  Proof.
  Admitted.

  Lemma taux_abs_conge_percentage : forall emp : INDICATEURS.employe, INDICATEURS.taux_abs_conge emp <= 100.
  Proof.
  Admitted.

  Lemma taux_abs_maladie_percentage : forall emp : INDICATEURS.employe, INDICATEURS.taux_abs_maladie emp <= 100.
  Proof.
  Admitted.

  Lemma utilisation_conge_percentage : forall emp : INDICATEURS.employe, INDICATEURS.utilisation_conge emp <= 100.
  Proof.
  Admitted.

End INDICATEURSProof.

