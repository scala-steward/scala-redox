package com.github.vitalsoftware.scalaredox.models

import com.github.vitalsoftware.macros._
import com.github.vitalsoftware.util.RobustPrimitives
import play.api.libs.json.{ Format, Reads, Writes }

/**
 * A New message is used to add a new document to the patient's chart.
 */
object MediaAvailability extends Enumeration {
  val Available, Unavailable = Value

  def defaultValue = Unavailable
  @transient implicit lazy val jsonFormat: Format[MediaAvailability.Value] =
    Format(Reads.enumNameReads(MediaAvailability), Writes.enumNameWrites)
}

/**
 *
 * @param FileType File type of the document. E.g. PDF, JPG
 * @param FileName Name of the file
 * @param FileContents (Base64) @see [Redox BLOB URI](http://docs.redoxengine.com/developer-documentation/sending-files-through-redox)
 * @param DocumentType Type of Document. This is the document type the file will be associated with (E.g. Consent Form, Treatment Plan)
 * @param DocumentID Unique identifier for this document. This ID is required in order to update the document
 * @param Provider ID of the Provider responsible for the document
 * @param Authenticated The authenticated status of the document. True or False. If True, Media.Authenticator must be filled out.
 * @param Authenticator The provider who authenticated the document
 * @param Availability Whether the document is available. Either: Available or Unavailable
 * @param Notifications List of providers that should be notified when this document posts to the patient's chart
 */
@jsonDefaults case class Media(
  FileType: String,
  FileName: String,
  FileContents: String,
  DocumentType: String,
  DocumentID: String,
  Provider: Option[Provider] = None,
  Authenticated: Option[String] = None,
  Authenticator: Option[Provider] = None,
  Availability: MediaAvailability.Value = MediaAvailability.defaultValue,
  Notifications: Seq[Provider] = Seq.empty
)

object Media extends RobustPrimitives
