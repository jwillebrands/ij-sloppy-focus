# Changelog

## [Unreleased]

### Added
- Add support for IDE version 2023.3.

### Changed
- [BREAKING] Changed minimum IDE version to 2022.1 (from 2021.1). This change was required to support 2023.3.
  Unfortunately, the UI DSL methods used to keep supporting 2021.1 have been removed in 2023.3.
  If this affects you, please raise an issue, and I'll see about setting up a separate channel for prior versions.

## [0.6.0] - 2023-11-05

### Fixed
- Prevent closing the Find/Replace in path dialog by specifically checking whether it is open before switching focus.

## [0.5.0] - 2023-06-06

### Changed
- Improved popup detection. Before only the ActionManager popup stack was checked. Now we also check whether
  the `PopupFactory` is aware of any active popups. This should prevent more popups (e.g. new Angular schematic) from
  being auto-closed due to switching focus.

## [0.4.1] - 2023-05-16

### Added
- Bump compatibility range to include 2023.2

## [0.4.0] - 2022-12-12

### Changed
- Switched to UI DSL v2.
- Switching focus is now prevent when Search Everywhere is active.

## [0.3.0]

### Changed
- Switching focus is now prevented while a context menu is active.

## [0.2.0]

### Added
- Make focus change delay configurable.
- Support switching focus to Terminal windows.
- Allow switching focus to any focusable component. This is configurable through settings. (default: off)

### Changed
- Debounce focus changes by adding a short delay between the mouse enter and switching focus.

## [0.1.1] - 2022-08-24

### Added
- Add custom icon.
- Supports sloppy focus for editor windows.
- Initial plugin version.

[Unreleased]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.6.0...HEAD
[0.6.0]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.5.0...v0.6.0
[0.5.0]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.4.1...v0.5.0
[0.4.1]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.4.0...v0.4.1
[0.4.0]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.3.0...v0.4.0
[0.3.0]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.2.0...v0.3.0
[0.2.0]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.1.1...v0.2.0
[0.1.1]: https://github.com/jwillebrands/ij-sloppy-focus/commits/v0.1.1
