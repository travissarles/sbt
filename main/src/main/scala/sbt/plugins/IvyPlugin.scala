package sbt
package plugins

import Def.Setting

/**
 * Plugin that enables resolving artifacts via ivy.
 *
 * Core Tasks
 * - `update`
 * - `makePom`
 * - `publish`
 * - `artifacts`
 * - `publishedArtifacts`
 */
object IvyPlugin extends AutoPlugin {
  // We are automatically included on everything that has the global module,
  // which is automatically included on everything.
  override def requires = CorePlugin
  override def trigger = allRequirements

  override lazy val projectSettings: Seq[Setting[_]] =
    Classpaths.ivyPublishSettings ++ Classpaths.ivyBaseSettings
  override lazy val globalSettings: Seq[Setting[_]] =
    Defaults.globalIvyCore
}
