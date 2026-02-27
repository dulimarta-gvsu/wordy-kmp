import Foundation
import SwiftUI
import ComposeApp

struct WordScreenView: View {
    @StateObject var vm = iosAppViewModel(commonVm: AppViewModel())
    @State var letterSize: Int = 40

    var body: some View {
        VStack {
            Button("Restart") {
                vm.selectRandomLetters()
            }
            .buttonStyle(.borderedProminent)
            .buttonBorderShape(.capsule)
            LetterGroup(letters: $vm.targetLetters, groupName: "Top", onRemoveLetter: { removePos in
                vm.moveTo(group: Origin.stock, pos: removePos)
            }) { arr in
                vm.rearrangeLetters(group: Origin.centerbox, arr: arr)

            }
            LetterGroup(letters: $vm.sourceLetters, groupName: "Bottom", onRemoveLetter: { removePos in
                vm.moveTo(group: Origin.centerbox, pos: removePos)
            } )  { arr in
                vm.rearrangeLetters(group: Origin.stock, arr: arr)
            }
            Spacer()
            Group {
                Text("Double tap to move among groups")
                Text("Drag to move within group")
            }
            .font(.system(size: 13))
            .italic(true)
        }.background(
            // Use this background to match Jetpack Compose theme
            Color(red:235.0/255,green:221.0/255,blue:254.0/255)
        )

    }
}

class IOSWordScreenFactory: WordScreenFactory {
    func createWordScreen() -> Any {
        return UIHostingController(rootView: WordScreenView())
    }
}