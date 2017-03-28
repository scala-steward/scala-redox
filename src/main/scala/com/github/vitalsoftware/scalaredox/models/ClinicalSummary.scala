package com.github.vitalsoftware.scalaredox.models

import com.github.vitalsoftware.macros._

/**
  * Created by apatzer on 3/20/17.
  */
@jsonDefaults case class ClinicalSummaryQuery(Meta: Meta, Patient: Patient)

/**
  * A Clinical Summary represents a snapshot of the patient's chart at a moment in time. It is structured in sections,
  * each focusing on a different aspect of the patient's chart, such as allergies, immunizations, and medications.
  * The full list of sections is at the left.
  *
  * You can obtain a Clinical Summary from an EHR via Query. You can send a Clinical Summary to an EHR via Push.
  */
@jsonDefaults case class ClinicalSummary(
  Meta: Meta,
  Header: Header,
  AdvanceDirectives: Seq[AdvanceDirective] = Seq.empty,
  Allergies: Seq[Allergy] = Seq.empty,
  Encounters: Seq[Encounter] = Seq.empty,
  FamilyHistory: Seq[FamilyHistory] = Seq.empty,
  Immunizations: Seq[Immunization] = Seq.empty,
  MedicalEquipment: Seq[MedicalEquipment] = Seq.empty,
  Medications: Seq[MedicationTaken] = Seq.empty,
  PlanOfCare: Option[PlanOfCare] = None,
  Problems: Seq[Problem] = Seq.empty,
  Procedures: Option[Procedures] = None,
  Results: Seq[Result] = Seq.empty,
  SocialHistory: Option[SocialHistory] = None,
  VitalSigns: Seq[VitalSigns] = Seq.empty
)