# Contributing to AnsibleOperator+

Thanks for taking the time to contribute!

## Branching

**Base branch:** `main` (stable and always buildable)

**Branch naming:**
- `feat/<issue-id>-<short-name>` — new features
- `fix/<issue-id>-<short-name>` — bug fixes
- `spike/<issue-id>-<short-name>` — investigations / prototypes
- `chore/<issue-id>-<short-name>` — chores / housekeeping

**Rules of thumb:**
- Keep `<short-name>` lowercase and dash-separated.
- Keep each branch focused on a single issue or change goal. Avoid unrelated refactors, dependency bumps, or
“while I’m here” fixes, open a separate branch/PR instead.

## Workflow

1. Create an Issue (Feature / Bug / Spike / chore).
2. Branch from `main`.
3. Keep the PR small and focused.
4. Ensure all checks pass and update docs/tests as needed.
5. Merge via PR (each commit in the PR should be a logical unit).
6. parent issue should be in the PR description.

## Commit messages

Title must start with the type of change (e.g. `feat:`, `fix:`, `spike:`, `chore:`) followed by a short description.
e.g. `feat: Add support for Ansible 2.11`

Body should contain a short description of the change and the motivation for it.

## Pull requests

 - The pull request body should follow the template.
 - Pull request title should be descriptive.
 - Pull request should be small and focused.

## Labels

Common labels:
- `epic`, `feature`, `bug`, `spike`, `docs`
- `blocker`, `chore`
- `good first issue`, `help wanted`

## Development notes (JetBrains plugins)

- Prefer IntelliJ Platform APIs (avoid GoLand-only APIs).
- Keep features **offline-first** where possible.
