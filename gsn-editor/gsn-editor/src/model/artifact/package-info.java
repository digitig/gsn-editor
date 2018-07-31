/**
 * <p>Artifacts correspond to the main evidentiary elements of an assurance case. By means of 
 * assertions (AssertedEvidence with isCounter = true/false), artifacts can be referenced (using 
 * ArtifactReferences) as supporting claims and arguments.</p>
 * <p>In general, artifacts are managed when the corresponding objects are available. For example, 
 * a test case is linked to the requirement that validates once the test case has already been 
 * created. However, artifact management might also require the specification of patterns (or 
 * templates) in order to allow a user, for instance, to indicate that a given artifact must be
 * created but it has not yet. A common scenario of this situation corresponds to the process during 
 * which a supplier and a certifier have to agree upon the artifacts that the supplier will have to 
 * provide as assurance evidence for a system. As a result of this process, artifact patterns could 
 * be specified, and such patterns would need to be made concrete during the lifecycle of the system. 
 * Artifact patterns are specified by means of the attribute 'isAbstract' (SACMElement). For example, 
 * a supplier and a certifier might agree upon the need for maintaining a hazard log during a 
 * system's lifecycle. Such a hazard log would initially be modeled as an Artifact that is abstract. 
 * Once created, the value of this attribute of the hazard log would be 'false'. The specification 
 * of artifact patterns also facilitates their reuse, as the corresponding artifacts might have to 
 * be created in the scope of more than one assurance case effort. Using again hazard logs as an
 * example, their structure might be the same for several systems, thus all the corresponding hazard 
 * logs might be based on a same abstract Artifact.</p>
 * <p>When made concrete, an Artifact can relate to many different types of information necessary for 
 * developing confidence in the Artifact and thus for assurance purposes. Such information can be 
 * regarded as meta-data or provenance information about an Artifact, provides information about its 
 * management, and is specified with the rest of specializations of ArtifactAsset. Using a design 
 * specification as an example, properties (Property) could be specified regarding its quality 
 * (completeness, consistency...), and it would have a lifecycle with events such as its creation 
 * and modifications. The specification could be created by using UML (Technique) in an Activity 
 * named ‘Specify system design’, stored in a Resource corresponding to a diagram created with some 
 * modeling tool, and later used as input for another Activity called ‘Verify system design’. 
 * A given person (Participant) playing the role of system designer could be the owner of the design 
 * specification, which would also relate to other artifacts: the requirements specification 
 * that satisfies, the architecture that implements, its verification report, etc. Associations 
 * between Artifacts and Activities /Events/Participants/ Resources/Techniques, and between 
 * Artifacts and Activities /Events/Participants/Resources/Techniques Participants can be recorded 
 * by means of ArtifactAssetRelationships.</p>
 * 
 * @author Tim Rowe
 *
 */
package model.artifact;