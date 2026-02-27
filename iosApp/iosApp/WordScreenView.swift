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
        }

    }
}

class IOSWordScreenFactory: WordScreenFactory {
    func createWordScreen() -> Any {
        return UIHostingController(rootView: WordScreenView())
    }
}